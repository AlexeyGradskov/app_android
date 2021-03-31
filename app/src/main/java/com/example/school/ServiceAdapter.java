package com.example.school;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Locale;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Service> services;

    ServiceAdapter(Context context, List<Service> services) {
        this.services = services;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ServiceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ServiceAdapter.ViewHolder holder, int position) {
        Service service = services.get(position);
        Glide.with(inflater.getContext()).asBitmap().load(service.getPhoto()).into(holder.serviceIMG);
        holder.title.setText(service.getTitle());
        if (service.getDiscount() != 0) {
            holder.oldCost.setText(String.format(Locale.ENGLISH, "Цена %d руб.", service.getCost()));
            holder.oldCost.setPaintFlags(holder.oldCost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.discount.setVisibility(View.VISIBLE);
            holder.discount.setText(String.format(Locale.ENGLISH, "Скидка %d руб.", (int) ((float) service.getCost() * service.getDiscount())));
        } else {
            holder.oldCost.setText(String.valueOf(service.getCost()));
        }
        holder.duration.setText(String.format(Locale.ENGLISH, "Время исполнения: %d мин", service.getDuration()));
    }


    @Override
    public int getItemCount() {
        return services.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView serviceIMG;
        final TextView title, oldCost, duration, discount;

        ViewHolder(View view) {
            super(view);
            serviceIMG = view.findViewById(R.id.serviceIMG);
            title = view.findViewById(R.id.textTitle);
            oldCost = view.findViewById(R.id.OldCostText);
            duration = view.findViewById(R.id.timeText);
            discount = view.findViewById(R.id.discountText);
        }
    }
}
