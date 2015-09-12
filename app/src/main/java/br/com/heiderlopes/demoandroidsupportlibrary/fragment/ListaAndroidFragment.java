package br.com.heiderlopes.demoandroidsupportlibrary.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.heiderlopes.demoandroidsupportlibrary.R;

public class ListaAndroidFragment extends Fragment {
    private RecyclerView rvLista;
    private LinearLayoutManager mLinearLayoutManager;
    private AndroidAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_android,container,false);
        rvLista = (RecyclerView) view.findViewById(R.id.rvLista);
        mLinearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mAdapter = new AndroidAdapter();

        rvLista.setLayoutManager(mLinearLayoutManager);
        rvLista.setAdapter(mAdapter);

        return view;
    }


    public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder>{


        @Override
        public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.cardview, parent, false);
            AndroidViewHolder holder = new AndroidViewHolder(view);

            return holder;
        }

        @Override
        public void onBindViewHolder(AndroidViewHolder holder, int position) {
            holder.tvTexto.setText("Item: "+position);
        }

        @Override
        public int getItemCount() {
            return 10;
        }

        public class AndroidViewHolder extends RecyclerView.ViewHolder{

            public TextView tvTexto;

            public AndroidViewHolder(View itemView){
                super(itemView);
                tvTexto = (TextView) itemView.findViewById(R.id.tvTexto);

            }
        }
    }
}