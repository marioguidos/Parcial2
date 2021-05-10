package com.example.parcial2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class PromedioAdapter extends RecyclerView.Adapter<PromedioAdapter.ViewHolder>
{

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView titulo,textViewKilometros,textViewCostos;
        ImageView imageViewKilometros;
        ImageView imageViewCostos;

        public ViewHolder(View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.txvTituloList);
            imageViewKilometros = itemView.findViewById(R.id.imgvKilometros);
            imageViewCostos = itemView.findViewById(R.id.imgvCosto);
            textViewKilometros = itemView.findViewById(R.id.txvKilometros);
            textViewCostos = itemView.findViewById(R.id.txvCosto);

        }
    }
    public List<PromedioModelo> listaPromedio;

    public PromedioAdapter(List<PromedioModelo>listaPromedio){
        this.listaPromedio=listaPromedio;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listview_promedio,parent,false);

        ViewHolder viewHolder= new ViewHolder(view);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titulo.setText(listaPromedio.get(position).getTitulo());
        holder.imageViewKilometros.setImageResource(listaPromedio.get(position).getImagenKilometros());
        holder.imageViewCostos.setImageResource(listaPromedio.get(position).getImagenCostos());
        holder.textViewKilometros.setText(listaPromedio.get(position).getKilometros());
        holder.textViewCostos.setText(listaPromedio.get(position).getCostos());

    }


    @Override
    public int getItemCount() {
        return listaPromedio.size();
    }
}

