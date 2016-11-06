package net.bluemoon.bankingpro.models;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.bluemoon.bankingpro.R;

/**
 * Created by mvnpavan on 28/01/16.
 */
public class BankViewHolder extends RecyclerView.ViewHolder {

    public ImageView bankImg;
    public TextView bankName;

    public BankViewHolder(View itemView) {
        super(itemView);
        bankImg = (ImageView) itemView.findViewById(R.id.bankLogoView);
        bankName = (TextView) itemView.findViewById(R.id.bankNameView);
    }
}
