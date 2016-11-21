package br.com.kakobotasso.escudosfiap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.kakobotasso.escudosfiap.R;
import br.com.kakobotasso.escudosfiap.model.Escudo;

public class EscudosListAdapter extends RecyclerView.Adapter<EscudosListAdapter.EscudosViewHolder> {
    private Context context;
    private List<Escudo> escudos;

    public EscudosListAdapter(Context context, List<Escudo> escudos) {
        this.context = context;
        this.escudos = escudos;
    }

    @Override
    public EscudosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.cardview_escudo, parent, false);
        return new EscudosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EscudosViewHolder holder, int position) {
        Escudo escudo = escudos.get(position);

        holder.tvNome.setText(escudo.getNome());
        holder.tvEstado.setText(escudo.getEstado());
        holder.tvAnoFundacao.setText(escudo.getTextoFundacao());

        Picasso.with(context)
                .load(escudo.getImagem())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivEscudo);

    }

    @Override
    public int getItemCount() {
        return escudos.size();
    }

    public static class EscudosViewHolder extends RecyclerView.ViewHolder{
        TextView tvNome;
        TextView tvEstado;
        ImageView ivEscudo;
        TextView tvAnoFundacao;

        public EscudosViewHolder(View itemView) {
            super(itemView);

            tvNome = (TextView) itemView.findViewById(R.id.nomeEscudo);
            tvEstado = (TextView) itemView.findViewById(R.id.estadoEscudo);
            ivEscudo = (ImageView) itemView.findViewById(R.id.imagemEscudo);
            tvAnoFundacao = (TextView) itemView.findViewById(R.id.anoEscudo);
        }
    }
}
