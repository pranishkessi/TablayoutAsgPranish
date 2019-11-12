package com.si.tablayoutasgpranish.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.si.tablayoutasgpranish.R;
import com.si.tablayoutasgpranish.adpter.ContactsAdapters;
import com.si.tablayoutasgpranish.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=root.findViewById(R.id.recyclerView);
        List<Contacts> contactsList = new ArrayList<>();
        contactsList.add(new Contacts("MATS","+8577123344",R.drawable.mats));
        contactsList.add(new Contacts("Gerad Pique","+85775432",R.drawable.pique));
        contactsList.add(new Contacts("Umtiti","+857876543",R.drawable.umtiti));
        contactsList.add(new Contacts("Jordi Alba","+8577123344",R.drawable.jordi));
        contactsList.add(new Contacts("Sergi Roborto","+8577123344",R.drawable.roborto));
        contactsList.add(new Contacts("Sergio Busqets","+8577123344",R.drawable.busquets));
        contactsList.add(new Contacts("Arthur Melo","+8577123445",R.drawable.arthur));
        contactsList.add(new Contacts("Franki De Jong","+857734567",R.drawable.dejong));
        contactsList.add(new Contacts("Anton Grizemann","+8576452134",R.drawable.grizi));
        contactsList.add(new Contacts("Luies Suarez","+8579084431",R.drawable.suarez));
        contactsList.add(new Contacts("Messi GOAT","+85734210871",R.drawable.messi));
        contactsList.add(new Contacts("Messi GOAT","+85734210871",R.drawable.messi));
        contactsList.add(new Contacts("Messi GOAT","+85734210871",R.drawable.messi));
        ContactsAdapters contactsAdapters = new ContactsAdapters(getActivity(),contactsList);
        recyclerView.setAdapter(contactsAdapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;

    }

}