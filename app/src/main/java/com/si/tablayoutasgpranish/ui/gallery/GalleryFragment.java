package com.si.tablayoutasgpranish.ui.gallery;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.si.tablayoutasgpranish.R;

import java.text.DecimalFormat;

public class GalleryFragment extends Fragment {
    private EditText etrdius;
    private Button btnCalculate;
    private TextView txtresult;

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery,container,false);
        etrdius = root.findViewById(R.id.etR);
        btnCalculate = root.findViewById(R.id.btnCalculateR);
        txtresult = root.findViewById(R.id.resultR);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(etrdius.getText().toString())){
                    DecimalFormat decimalFormat = new DecimalFormat("0.00");
                    double first,  result;
                    first = Double.parseDouble(etrdius.getText().toString());
                    result = ((22* first * first)/7);
                    txtresult.setText("Area Of Circle with radius" + decimalFormat.format(first)+ " is " + decimalFormat.format(result));
                }else {
                    etrdius.setError("Enter Value");
                }
            }
        });
        return root;

    }
}