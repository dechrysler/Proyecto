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

public class AdapterCompra  extends BaseAdapter{
    private LayoutInflater inflater;
    private int idLayout;
    private List<Plato> platos;

    public AdapterCompra(Context contexto, int idLayout, List<Plato> platos) {

        inflater = LayoutInflater.from(contexto);
        this.idLayout = idLayout;
        this.platos =platos;
    }
    static class ViewHolder {
        TextView tvNombr;
        TextView tvPreci;
        TextView tvCantidad;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      ViewHolder holder = null;

        if (convertView == null) {
            convertView = inflater.inflate(idLayout, null);

            holder = new ViewHolder();
            holder.tvNombr = convertView.findViewById(R.id.tvNom);
            holder.tvPreci = convertView.findViewById(R.id.tvPrec);
            holder.tvCantidad=convertView.findViewById(R.id.tvCantidad);
            convertView.setTag(holder);
        }
        else {

            holder = (ViewHolder) convertView.getTag();
        }

        Plato plato = platos.get(position);
        holder.tvNombr.setText(plato.getNombre());
        holder.tvPreci.setText(String.valueOf(plato.getPrecio()));
        int x=0;
        int cantidad=1;
        for(Plato plat:platos)
        {
            if(plat.getId()==plato.getId())
            {
                if(position!=x) {
                    cantidad++;
                    platos.remove(x);
                }
            }
            x++;
        }
        holder.tvCantidad.setText(""+cantidad);
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

