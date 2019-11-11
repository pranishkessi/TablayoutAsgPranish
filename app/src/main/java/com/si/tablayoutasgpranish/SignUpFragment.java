package com.si.tablayoutasgpranish;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.si.tablayoutasgpranish.implement.InterfaceClassIMPL;
import com.si.tablayoutasgpranish.implement.TabLayoutInterface;
import com.si.tablayoutasgpranish.model.Datacenter;


public class SignUpFragment extends Fragment {
    EditText sName, sPassword, sRePassword;
    Button btnSignUP;

    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        sName = view.findViewById(R.id.signupName);
        sPassword = view.findViewById(R.id.sign1Pass);
        sRePassword = view.findViewById(R.id.sign2Pass);
        btnSignUP = view.findViewById(R.id.btnsignup);
        btnSignUP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStore();

            }
        });
        return view;

    }

    public void DataStore() {
        String name = "", password = "", repassword = "";
        if (!TextUtils.isEmpty(sName.getText().toString())) {
            name = sName.getText().toString();
            if (!TextUtils.isEmpty(sPassword.getText().toString())) {
                password = sPassword.getText().toString();
                if (!TextUtils.isEmpty(sRePassword.getText().toString())) {
                    repassword = sRePassword.getText().toString();
                } else {
                    sRePassword.setError("Confirm Your Password");
                    return;
                }

            } else {
                sPassword.setError("Enter Your Password");
                return;
            }
        } else {
            sName.setError("Enter Your NAme");
            return;
        }

        if (password.equals(repassword)) {
            Datacenter datacenter = new Datacenter();
            datacenter.setPassword(password);
            datacenter.setName(name);
            TabLayoutInterface impl = new InterfaceClassIMPL();
            if (impl.adduser(datacenter)) {
                Toast.makeText(getActivity(), "SWIPE LEFT TO LOGIN", Toast.LENGTH_SHORT).show();
                Clear();
            }

        } else {
            Toast.makeText(getActivity(), "Please Enter password as entered above", Toast.LENGTH_SHORT).show();

        }
    }

    public void Clear() {
        sName.setText("");
        sPassword.setText("");
        sRePassword.setText("");
    }


}
