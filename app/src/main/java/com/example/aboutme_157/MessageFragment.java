package com.example.aboutme_157;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.aboutme_157.databinding.FragmentMessageBinding;


public class MessageFragment extends Fragment {

    private FragmentMessageBinding mBinding;

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = FragmentMessageBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBinding.buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBinding.buttonContact.setVisibility(View.GONE);
                mBinding.msgHolder.setVisibility(View.VISIBLE);
                mBinding.Sndbutton.setVisibility(View.VISIBLE);
            }
        });

        mBinding.Sndbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBinding.msgET.getText().toString().length() != 0){
                    String message = mBinding.msgET.getText().toString();
                    sendMessage(message);
                } else {
                    Toast.makeText(getContext(), "Debes ingresar un mensaje", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void sendMessage(String message) {
        Intent mIntent = new Intent(Intent.ACTION_SENDTO);
        mIntent.setData(Uri.parse("mailto:"));
        mIntent.putExtra(Intent.EXTRA_EMAIL, "cristian.vidal.lopez@gmail.com");
        mIntent.putExtra(Intent.EXTRA_SUBJECT, "Correo de contacto a traves de app");
        mIntent.putExtra(Intent.EXTRA_TEXT, message);
        startActivity(mIntent);
    }

}