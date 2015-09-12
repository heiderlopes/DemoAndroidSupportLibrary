package br.com.heiderlopes.demoandroidsupportlibrary;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

public class CadastroFragment extends Fragment {

    private CoordinatorLayout mCoordinator;
    private FloatingActionButton fabSalvar;
    public CadastroFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);
        mCoordinator = (CoordinatorLayout) view.findViewById(R.id.mCoordinator);
        fabSalvar = (FloatingActionButton)view.findViewById(R.id.fabSalvar);
        fabSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(mCoordinator,
                        "Cadastro com sucesso", Snackbar.LENGTH_LONG).
                        setAction("Desfazer", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                Toast.makeText(getActivity().getApplicationContext(),
                                        "Desfeito",
                                        Toast.LENGTH_SHORT).show();
                            }

                        }).show();
            }
        });
        return view;
    }

}
