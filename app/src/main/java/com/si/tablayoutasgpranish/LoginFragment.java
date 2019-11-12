package com.si.tablayoutasgpranish;

import android.content.Context;
import android.content.Intent;
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


public class LoginFragment extends Fragment {
    EditText loginName, loginPassword;
    Button btnlogin;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        loginName = view.findViewById(R.id.loginName);
        loginPassword = view.findViewById(R.id.loginPass);
        btnlogin = view.findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataStore();

            }
        });
        return view;
    }


    public void DataStore() {
        Datacenter datacenter = new Datacenter();
        String name = "", password = "";
        if (!TextUtils.isEmpty(loginName.getText().toString())) {
            name = loginName.getText().toString();

            if (!TextUtils.isEmpty(loginPassword.getText().toString())) {
                password = loginPassword.getText().toString();
            } else {
                loginPassword.setError("Enter Password");
                return;
            }
        } else {
            loginName.setError("Enter Name");
            return;
        }

        TabLayoutInterface impl = new InterfaceClassIMPL();
        if (impl.Checkuser(name, password)) {
            Toast.makeText(getActivity(), "Welcome" + name, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(), NavMain.class);
            intent.putExtra("names", name);
            startActivity(intent);

        } else {
            Toast.makeText(getActivity(), "Login Failed Check Again!!", Toast.LENGTH_SHORT).show();
        }
    }

}




