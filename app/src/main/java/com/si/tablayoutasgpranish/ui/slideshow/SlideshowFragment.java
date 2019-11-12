package com.si.tablayoutasgpranish.ui.slideshow;

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

public class SlideshowFragment extends Fragment {
    private EditText etFirst, etSecond;
    private Button btnCalculate;
    private TextView txtresult;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_slideshow,container, false);
       etFirst = view.findViewById(R.id.etFirst);
       etSecond = view.findViewById(R.id.etSecond);
       btnCalculate = view.findViewById(R.id.btnCaluclate);
       txtresult = view.findViewById(R.id.resultadd);

       btnCalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               double first, second, result;
               DecimalFormat decimalFormat = new DecimalFormat("0.00");
               if (!TextUtils.isEmpty(etFirst.getText().toString())){
                   first = Double.parseDouble(etFirst.getText().toString());
                   if (!TextUtils.isEmpty(etSecond.getText().toString())){
                       second = Double.parseDouble(etSecond.getText().toString());
                       result = first + second;
                       txtresult.setText(""+decimalFormat.format(first)+ " + "+decimalFormat.format(second)+" = "+ decimalFormat.format(result));
                   }else {
                       etSecond.setError("Enter a Value");
                   }
               }else {
                   etFirst.setError("Enter a Value");
               }
           }
       });
       return view;
    }
}