package com.jmnl2020.attendanceapp3;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class AdapterStudentFragment extends RecyclerView.Adapter {

    boolean check = true;

    Context context;
    ArrayList<ItemStudentList> items;

    public AdapterStudentFragment(Context context, ArrayList<ItemStudentList> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_student, parent, false);

        ViewHolder holder = new ViewHolder(itemView);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder viewHolder = (ViewHolder) holder;
        ItemStudentList item = items.get(position);

        viewHolder.tv.setText(item.name);
        // boolean 배열을 하나씩 입력시키자!

        //1. 개인마다 토글버튼 배열이 있음
        //2. 개인의 토글버튼을 체크해주는 메소드가 필요

        //토글버튼 on/off
        boolean[] checking =parseIntDay(Integer.parseInt(G.dtos.get(position).day));

        viewHolder.tbMon.setChecked(checking[0]);
        viewHolder.tbTue.setChecked(checking[1]);
        viewHolder.tbWed.setChecked(checking[2]);
        viewHolder.tbThu.setChecked(checking[3]);
        viewHolder.tbFri.setChecked(checking[4]);
        viewHolder.tbSat.setChecked(checking[5]);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }




    public boolean[] parseIntDay(int day) {
        int pid = android.os.Process.myPid();
        String whiteList = "logcat -P '" + pid + "'";
        try {
            Runtime.getRuntime().exec(whiteList).waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean[] checked = new boolean[6];
        int num = day;
        int mask = 0b00000001;

        for (int i = 0; i < 6; i++) {

            int n = num & mask;
            if (n == 1) {
                checked[i] = true;

            } else {
                checked[i] = false;
            }
            num = num >> 1;
//            Log.i("aaa", checked[i] + "");
        }
//        Log.i("aa", "한바퀴!");
//        Log.i("aaa", day+"");

        return checked;
    }

    public void removeItem(int adapterPosition) {
        items.remove(adapterPosition);
        notifyItemRemoved(adapterPosition);
    }

    public void restoreItem(ItemStudentList item, int position) {
        items.add(position, item);
        // notify item added by position
        notifyItemInserted(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ToggleButton tbMon, tbTue, tbWed, tbThu, tbFri, tbSat;
        TextView tv;

        LinearLayout viewForeground;
        RelativeLayout viewBackground;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv= itemView.findViewById(R.id.tv_stdListName);

            tbMon = itemView.findViewById(R.id.tb_mon);
            tbTue = itemView.findViewById(R.id.tb_tue);
            tbWed = itemView.findViewById(R.id.tb_wed);
            tbThu = itemView.findViewById(R.id.tb_thu);
            tbFri = itemView.findViewById(R.id.tb_fri);
            tbSat = itemView.findViewById(R.id.tb_sat);

            viewForeground = itemView.findViewById(R.id.view_foreground);
            viewBackground = itemView.findViewById(R.id.view_background);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    ItemStudentList item= items.get( getLayoutPosition() );
                    setDialog(item);

                }
            });


        }// constructor

        @SuppressLint("ResourceAsColor")
        public void setDialog(ItemStudentList item){


            //student info xml 이용해서 alertdialog 만들기
            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            //화면생성
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.student_info, null);

            TextView name = view.findViewById(R.id.tv_nameInfo);
            name.setText(item.name);

            name = view.findViewById(R.id.tv_nameinfo);
            name.setText(item.name);

            //items 에 없는 info 가져와서 적용시키기
            TextView bday = view.findViewById(R.id.tv_bthdayinfo);
            TextView contactNum = view.findViewById(R.id.tv_contactinfo);
            TextView par1Name= view.findViewById(R.id.tv_par1nameinfo);
            TextView par1Num= view.findViewById(R.id.tv_par1phoneinfo);
            TextView par2Name= view.findViewById(R.id.tv_par2nameinfo);
            TextView par2Num= view.findViewById(R.id.tv_par2phoneinfo);

            bday.setText(item.birthday+"");
            contactNum.setText(item.contact);
            par1Name.setText(item.par1name);
            par1Num.setText(item.par1phone);
            par2Name.setText(item.par2name);
            par2Num.setText(item.par2phone);

            //재학 버튼 클릭 -> 휴원생 목록
            Button btnState = view.findViewById(R.id.btn_state);
            btnState.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    if (check == true){
                        btnState.setBackgroundResource(R.drawable.btnbgred);
                        btnState.setText("휴학");
                        check = false;
                    }else {
                        btnState.setBackgroundResource(R.drawable.btnbg);
                        btnState.setText("재학");
                        check = true;
                    }
                }
            });


            //다이얼로그 버튼
            builder.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    Intent intent = new Intent(context, StudentEditActivity.class);
                    context.startActivity(intent);

                    if (check == false){
                        //학생이 휴학중이면 휴학생 목록에 add
                        //fragment에서 열리지 않은 activity로 아이템전달...
                    }

                }
            });

            //취소버튼
            builder.setNeutralButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            //확인버튼
            builder.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });

            builder.setView(view);

            AlertDialog dialog = builder.create();

            //화면 밖을 클릭하면 취소됨
            //왜 안 되는거지
            dialog.setCanceledOnTouchOutside(true);

            builder.show();
        }

    }// ViewHolder end.

}


