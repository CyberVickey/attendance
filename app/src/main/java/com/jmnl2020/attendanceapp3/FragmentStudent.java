package com.jmnl2020.attendanceapp3;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.kakao.auth.authorization.AuthorizationResult;

import java.util.ArrayList;

public class FragmentStudent extends Fragment {

    ///////////////리사이클러뷰///////////////
    ArrayList<ItemStudentList> items = new ArrayList<>();
    RecyclerView recyclerView;
    AdapterStudentFragment adapter;

    //fab
    FloatingActionButton fab;

    final int fabIntentCode = 1212;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);

        //버튼테스트트
//       Button btn = view.findViewById(R.id.clickTest);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                adapter.notifyDataSetChanged();
//            }
//        });

        adapter = new AdapterStudentFragment(getActivity(), items);
        recyclerView = view.findViewById(R.id.recyclerview_frg4);
        recyclerView.setAdapter(adapter);

        fab = view.findViewById(R.id.fab_std);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), StudentEditActivity.class);
                getActivity().startActivity(intent);

            }
        });

        abstract class ItemTouchHelperListener {
            public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position);
        }


        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }
            @SuppressLint("ResourceAsColor")
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                String name = items.get(viewHolder.getAdapterPosition()).studentName;

                final ItemStudentList deletedItem = items.get(viewHolder.getAdapterPosition());
                final int deleteIndex = viewHolder.getAdapterPosition();

                //remove the item from recycler view
                adapter.removeItem(viewHolder.getAdapterPosition());

                Snackbar snackbar = Snackbar
                        .make(view, name + " removed from cart!", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        // undo is selected, restore the deleted item
                        adapter.restoreItem(deletedItem, deleteIndex);
                    }
                });
                snackbar.setActionTextColor(R.color.myColorLemon);
                snackbar.show();
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder,
                                    float dX, float dY, int actionState, boolean isCurrentlyActive) {
                // view the background view
            }

        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);


        return view;

    }// onCreateView end.

    @Override
    public void onResume() {
        super.onResume();

        Toast.makeText(getActivity(), "fragment Student onResume", Toast.LENGTH_SHORT).show();

        items.clear();

        adapter.notifyDataSetChanged();

        for(int i = 0; i<G.dtos.size(); i++){
            items.add(new ItemStudentList(G.dtos.get(i).name));
            adapter.notifyItemInserted(items.size()-1);
        }

    }
}


