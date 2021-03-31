package com.example.school;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

    public class ServiceAdapter  extends RecyclerView.Adapter<ServiceAdapter.ViewHolder>{

        private final LayoutInflater inflater;
        private final List<Service> services;

        ServiceAdapter(Context context, List<Service> services) {
            this.services = services;
            this.inflater = LayoutInflater.from(context);
        }
        @Override
        public ServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ServiceAdapter.ViewHolder holder, int position) {
            Service service = services.get(position);
            holder.serviceIMG.setImageResource(service.getMainImagePath());
            holder.title.setText(service.getTitle());
            holder.oldCost.setPaintFlags(holder.oldCost.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.newCost.setText((int) service.getCost());
            holder.duration.setText(service.getDuration());
            holder.discount.setText(service.getDiscount());
        }

        @Override
        public int getItemCount() {
            return services.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            final ImageView serviceIMG;
            final TextView title, oldCost, newCost, duration, discount;
            ViewHolder(View view){
                super(view);
                serviceIMG = (ImageView)view.findViewById(R.id.serviceIMG);
                title = (TextView) view.findViewById(R.id.textTitle);
                oldCost = (TextView) view.findViewById(R.id.OldCostText);
                newCost = (TextView) view.findViewById(R.id.newCostText);
                duration = (TextView) view.findViewById(R.id.timeText);
                discount = (TextView) view.findViewById(R.id.discountText);
            }
        }
}
