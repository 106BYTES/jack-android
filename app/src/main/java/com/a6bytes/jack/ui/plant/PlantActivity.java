package com.a6bytes.jack.ui.plant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.a6bytes.jack.R;

public class PlantActivity extends AppCompatActivity {

    BottomSheetDialog waterSheetDialog;
    View waterSheetLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        waterSheetLayout = getLayoutInflater().inflate(R.layout.sheet_water, null);

        waterSheetDialog = new BottomSheetDialog(this);
        waterSheetDialog.setContentView(waterSheetLayout);
        waterSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                waterSheetDialog.dismiss();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                waterSheetDialog = newWaterSheetDialog();
                showWaterSheetDialog(view);
            }
        });
    }

    public void showWaterSheetDialog(@Nullable View view){
        waterSheetDialog.show();
    }

    public BottomSheetDialog newWaterSheetDialog(){
        BottomSheetDialog md = new BottomSheetDialog(this);
        md.setContentView(waterSheetLayout);
        return md;
    }
}
