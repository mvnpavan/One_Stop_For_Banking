package net.bluemoon.bankingpro.ui.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import net.bluemoon.bankingpro.R;
import net.bluemoon.bankingpro.callbacks.SingleBankSelectedCallback;
import net.bluemoon.bankingpro.models.SingleBank;
import net.bluemoon.bankingpro.ui.activitys.BrowsingView;
import net.bluemoon.bankingpro.ui.activitys.Settings;
import net.bluemoon.bankingpro.ui.adapters.BankingListAdapter;
import net.bluemoon.bankingpro.utils.Constants;
import net.bluemoon.bankingpro.utils.DataHolder;
import net.bluemoon.bankingpro.utils.utils;

import java.util.ArrayList;
import java.util.List;


public class FavouriteBanksFragment extends Fragment implements SearchView.OnQueryTextListener {

    private RecyclerView bookmarkedView;
    private List<SingleBank> bankList;
    private List<SingleBank> searchBanks;
    private BankingListAdapter adapter;

    public FavouriteBanksFragment() {

    }

    private SingleBankSelectedCallback callback = new SingleBankSelectedCallback() {
        @Override
        public void onBankSelected(View view) {
            int position = bookmarkedView.getChildAdapterPosition(view);
            if (utils.isNetworkAvailable(getActivity())) {
                Intent intent = new Intent(getActivity(), BrowsingView.class);
                intent.putExtra(Constants.URL_IDENTIFIER, searchBanks.get(position).getBank_url());
                intent.putExtra(Constants.BANK_IDENTIFIER, searchBanks.get(position).getBank_name());
                getActivity().startActivity(intent);
            } else {
                networkAlert();
            }
        }

        @Override
        public void onBankLongSelected(View view) {
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setHasOptionsMenu(true);
        View rootView = inflater.inflate(R.layout.fragment_one, container, false);
        bookmarkedView = (RecyclerView) rootView.findViewById(R.id.bookmarkedBankView);
        bookmarkedView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        bookmarkedView.setLayoutManager(layoutManager);
        new FetchBanks().execute();

        return rootView;
    }

    class FetchBanks extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            DataHolder dataHolder = new DataHolder();
            bankList = dataHolder.getBankList();
            searchBanks = bankList;
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new BankingListAdapter(getActivity(), bankList, callback);
            bookmarkedView.setAdapter(adapter);
            bookmarkedView.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<SingleBank> filteredModelList = filter(bankList, newText);
        adapter.setFilter(filteredModelList);
        searchBanks = filteredModelList;
        return false;
    }

    private List<SingleBank> filter(List<SingleBank> models, String query) {
        query = query.toLowerCase();

        final List<SingleBank> filteredModelList = new ArrayList<>();
        for (SingleBank model : models) {
            final String text = model.getBank_name().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_rating:
                utils.openAppInPlayStore(getActivity(), Constants.PAID_BUNDLE_ID);
                break;
            case R.id.menu_feedback:
                utils.feedbackMail(getActivity());
                break;
            case R.id.menu_settings:
                getActivity().startActivity(new Intent(getActivity(), Settings.class));
                break;
            case R.id.menu_exit:
                exitApp();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);

        final MenuItem item = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(item);
        searchView.setOnQueryTextListener(FavouriteBanksFragment.this);

        MenuItemCompat.setOnActionExpandListener(item,
                new MenuItemCompat.OnActionExpandListener() {
                    @Override
                    public boolean onMenuItemActionCollapse(MenuItem item) {
                        // Do something when collapsed
                        adapter.setFilter(bankList);
                        searchBanks = bankList;
                        return true; // Return true to collapse action view
                    }

                    @Override
                    public boolean onMenuItemActionExpand(MenuItem item) {
                        // Do something when expanded
                        return true; // Return true to expand action view
                    }
                });
    }

    private void networkAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(R.string.network_err);
        builder.setMessage(R.string.network_err_desc);
        builder.setPositiveButton(R.string.dialog_button_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create().show();
    }

    private void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(false);
        builder.setTitle(R.string.exit);
        builder.setMessage(R.string.exit_msg);
        builder.setPositiveButton(R.string.dialog_button_positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                getActivity().finish();
            }
        });
        builder.setNegativeButton(R.string.dialog_button_negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.create().show();
    }



}
