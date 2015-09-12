package br.com.heiderlopes.demoandroidsupportlibrary;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.heiderlopes.demoandroidsupportlibrary.fragment.ListaAndroidFragment;

public class CollapseActivity extends AppCompatActivity {

    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private View mHeaderLayout;
    private ImageView mImageViewHeader;
    private TextView mHeaderRating;
    private Fragment fragment;

    private static final String FRAGMENT_TAG="CollapseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collapse);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbar);
        mHeaderLayout = findViewById(R.id.headerLayout);
        mImageViewHeader = (ImageView) mHeaderLayout.findViewById(R.id.header_img);
        mHeaderRating = (TextView) mHeaderLayout.findViewById(R.id.current_rating);

        //Define o titulo directamente no Collapsible toolbar para poder fazer o efeito de dimunuir e aumentar
        //quando comprimida ou expandida respectivamente
        mCollapsingToolbarLayout.setTitle("Android");

        mImageViewHeader.setImageResource(R.drawable.banner_android);

        //Define o valor do rating
        //mHeaderRating.setText("Winner");

        if(savedInstanceState!=null){
            fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        }
        else{
            fragment = new ListaAndroidFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.details_container,fragment,FRAGMENT_TAG).commit();

    }
}
