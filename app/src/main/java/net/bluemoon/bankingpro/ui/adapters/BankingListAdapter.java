package net.bluemoon.bankingpro.ui.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.bluemoon.bankingpro.R;
import net.bluemoon.bankingpro.callbacks.SingleBankSelectedCallback;
import net.bluemoon.bankingpro.models.BankViewHolder;
import net.bluemoon.bankingpro.models.SingleBank;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mvnpavan on 28/01/16.
 */
public class BankingListAdapter extends RecyclerView.Adapter<BankViewHolder> {

    private final Context context;
    private List<SingleBank> bankingList;
    private final SingleBankSelectedCallback callback;

    public BankingListAdapter(Context context, List<SingleBank> bankingList , SingleBankSelectedCallback callback) {
        this.context = context;
        this.bankingList = bankingList;
        this.callback = callback;
    }

    @Override
    public BankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.bank_item, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.onBankSelected(view);
            }
        });

        view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                callback.onBankLongSelected(view);
                return false;
            }
        });
        return new BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BankViewHolder holder, int position) {

        SingleBank bank = bankingList.get(position);

        holder.bankName.setText(bank.getBank_name());
        holder.bankImg.setImageDrawable(getDrawable(bank.getBank_img()));

    }

    @Override
    public int getItemCount() {
        return bankingList.size();
    }

    public Drawable getDrawable(String name){
        int resourceId= getId(name , R.drawable.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return context.getResources().getDrawable(resourceId, context.getTheme());
        } else {
            return  context.getResources().getDrawable(resourceId);
        }
    }

    public static int getId(String resourceName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resourceName);
            return idField.getInt(idField);
        } catch (Exception e) {
            throw new RuntimeException("No resource ID found for: "
                    + resourceName + " / " + c, e);
        }
    }

    public void setFilter(List<SingleBank> bankingList){
        this.bankingList = new ArrayList<>();
        this.bankingList.addAll(bankingList);
        notifyDataSetChanged();
    }
}
