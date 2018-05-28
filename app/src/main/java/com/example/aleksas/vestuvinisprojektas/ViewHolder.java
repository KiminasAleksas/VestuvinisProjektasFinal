package com.example.aleksas.vestuvinisprojektas;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ViewHolder extends RecyclerView.ViewHolder{

    View mView;

    public ViewHolder(View itemView)
    {
        super(itemView);

        mView = itemView;
    }

    public void setDetails(Context ctx, String Vardas, String Aprašas, String Nuotrauka, String Paštas)
    {
        TextView mVardasView = mView.findViewById(R.id.Vardas);
        TextView mAprašasView = mView.findViewById(R.id.Aprašas);
        ImageView mNuotraukaView = mView.findViewById(R.id.Nuotrauka);
        TextView mPaštasView = mView.findViewById(R.id.Paštas);

        mVardasView.setText(Vardas);
        mAprašasView.setText(Aprašas);
        Picasso.get().load(Nuotrauka).into(mNuotraukaView);
        mPaštasView.setText(Paštas);

    }
}
