package com.example.xieyang.frags;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.demo3.R;
import com.example.xieyang.aty.Tool_other_festival_Activity;
import com.example.xieyang.aty.Tool_time_estimation_Activity;
import com.example.xieyang.aty.Tool_time_of_other_Avtivity;
import com.example.xieyang.common.BaseFragment;
import com.example.xieyang.presenter.Frag_4_Presenter;
import com.example.xieyang.view.Frag_4_View;


public class Frag_4 extends BaseFragment<Frag_4_View,Frag_4_Presenter>{

	private View view;
	private LinearLayout time_of_other_layout, time_tuisuan_layout,
			time_of_birthday_layout, time_of_constellation,tool_of_other_festival;

	public Frag_4() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		view = View.inflate(getActivity(), R.layout.menus_frag_person_tools,
				null);


		time_of_other_layout = (LinearLayout)view.findViewById(R.id.time_of_other_layout);
		time_tuisuan_layout = (LinearLayout) view.findViewById(R.id.time_tuisuan_layout);
		time_of_birthday_layout = (LinearLayout) view.findViewById(R.id.time_of_birthday_layout);
		time_of_constellation = (LinearLayout) view.findViewById(R.id.time_of_constellation_layout);
		tool_of_other_festival= (LinearLayout) view.findViewById(R.id.tool_of_other_festival);
		time_of_other_layout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent =new Intent(getActivity(), Tool_time_of_other_Avtivity.class);
				startActivity(intent);
			}
		});

		time_tuisuan_layout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent =new Intent(getActivity(), Tool_time_estimation_Activity.class);
				startActivity(intent);
			}
		});

		time_of_birthday_layout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "生日本",Toast.LENGTH_SHORT).show();
			}
		});

		time_of_constellation.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "星座运势",Toast.LENGTH_SHORT).show();
			}
		});
		tool_of_other_festival.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(), Tool_other_festival_Activity.class);
				startActivity(intent);
			}
		});


		return view;
	}

	@Override
	public Frag_4_Presenter createPresenter() {
		return new Frag_4_Presenter();
	}
}
