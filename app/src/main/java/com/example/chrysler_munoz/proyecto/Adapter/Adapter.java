package com.example.chrysler_munoz.proyecto.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.chrysler_munoz.proyecto.Base.Plato;
import com.example.chrysler_munoz.proyecto.R;

import java.util.List;

public class Adapter extends BaseAdapter {
    private LayoutInflater inflater;
    private int idLayout;
    private List<Plato> platos;

    public Adapter(Context contexto, int idLayout, List<Plato> platos) {

        inflater = LayoutInflater.from(contexto);
        this.idLayout = idLayout;
        this.platos =platos;
    }
    static class ViewHolder {
        TextView tvNombre;
        TextView tvDescripcion;
        TextView tvPrecio;
    }

    @Override
    public View getView(int posicion, View convertView, ViewGroup parent) {

        ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(idLayout, null);

            holder = new ViewHolder();
             holder.tvNombre = convertView.findViewById(R.id.tvNombre);
            holder.tvDescripcion = convertView.findViewById(R.id.tvDescripcion);
            holder.tvPrecio = convertView.findViewById(R.id.tvPrecio);

            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }

        Plato plato = platos.get(posicion);
        holder.tvNombre.setText(plato.getNombre());
        holder.tvDescripcion.setText(plato.getDescripcion());
        holder.tvPrecio.setText(String.valueOf(plato.getPrecio()));
        return convertView;
    }
    @Override
    public int getCount() {
        return platos.size();
    }

    @Override
    public Object getItem(int position) {
        return platos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return platos.get(position).getId();
    }

}
