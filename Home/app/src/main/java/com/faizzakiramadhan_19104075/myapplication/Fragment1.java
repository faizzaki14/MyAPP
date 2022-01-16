//package com.faizzakiramadhan_19104075.myapplication;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import androidx.annotation.NonNull;
//import androidx.fragment.app.Fragment;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import com.faizzakiramadhan_19104075.myapplication.ui.Profile.profilefrg;
//
//import javax.annotation.Nullable;
//
//public class Fragment1 extends Fragment implements View.OnClickListener{
//
//
//    @Nullable
//    @Override
//    public View onCreateView( @NonNull LayoutInflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_1,container, false);
//        return view;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState){
//        super.onActivityCreated(savedInstanceState);
//        TextView textView = getActivity().findViewById(R.id.tvprofilee);
//
//    }
//
//    @Override
//    public void onClick(View v) {
//
//        switch (View.getId()){
//            case R.id.tvprofilee:
//            Intent intent = new Intent(getActivity(), profilefrg.class);
//            startActivity(intent);
//        }
//    }
//}