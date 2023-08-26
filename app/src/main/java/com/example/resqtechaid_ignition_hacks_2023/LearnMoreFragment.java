package com.example.resqtechaid_ignition_hacks_2023;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class LearnMoreFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public LearnMoreFragment() {
        // Required empty public constructor
    }

    public static LearnMoreFragment newInstance(String param1, String param2) {
        LearnMoreFragment fragment = new LearnMoreFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_learnmore, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final TextView textStroke = view.findViewById(R.id.LearnMoreStroke);
        final TextView textPoison = view.findViewById(R.id.LearnMoreFoodPoisoning);
        final TextView textWound = view.findViewById(R.id.LearnMoreWound);
        final TextView textConcussion = view.findViewById(R.id.LearnMoreConcussion);
        final TextView textHeartAttack = view.findViewById(R.id.LearnMoreHeartAttack);
        final TextView textAllergicReaction = view.findViewById(R.id.LearnMoreAllergicReaction);

        Button strokeLearn = view.findViewById(R.id.btnStrokeLearn);
        Button poisonLearn = view.findViewById(R.id.btnPoisonLearn);
        Button woundLearn = view.findViewById(R.id.btnWounds);
        Button concussionLearn = view.findViewById(R.id.btnConcussion);
        Button heartAttackLearn = view.findViewById(R.id.btnHeartAttack);
        Button allergicReactionLearn = view.findViewById(R.id.btnAllergic);

        strokeLearn.setOnClickListener(v -> {
            hideAllTextViews();
            if (textStroke.getVisibility() == View.GONE) {
                textStroke.setVisibility(View.VISIBLE);
            }
        });

        poisonLearn.setOnClickListener(v -> {
            hideAllTextViews();
            if (textPoison.getVisibility() == View.GONE) {
                textPoison.setVisibility(View.VISIBLE);
            }
        });

        woundLearn.setOnClickListener(v -> {
            hideAllTextViews();
            if (textWound.getVisibility() == View.GONE) {
                textWound.setVisibility(View.VISIBLE);
            }
        });

        concussionLearn.setOnClickListener(v -> {
            hideAllTextViews();
            if (textConcussion.getVisibility() == View.GONE) {
                textConcussion.setVisibility(View.VISIBLE);
            }
        });

        heartAttackLearn.setOnClickListener(v -> {
            hideAllTextViews();
            if (textHeartAttack.getVisibility() == View.GONE) {
                textHeartAttack.setVisibility(View.VISIBLE);
            }
        });

        allergicReactionLearn.setOnClickListener(v -> {
            hideAllTextViews();
            if (textAllergicReaction.getVisibility() == View.GONE) {
                textAllergicReaction.setVisibility(View.VISIBLE);
            }
        });
    }

    private void hideAllTextViews() {
        TextView textStroke = getView().findViewById(R.id.LearnMoreStroke);
        TextView textPoison = getView().findViewById(R.id.LearnMoreFoodPoisoning);
        TextView textWound = getView().findViewById(R.id.LearnMoreWound);
        TextView textConcussion = getView().findViewById(R.id.LearnMoreConcussion);
        TextView textHeartAttack = getView().findViewById(R.id.LearnMoreHeartAttack);
        TextView textAllergicReaction = getView().findViewById(R.id.LearnMoreAllergicReaction);

        textStroke.setVisibility(View.GONE);
        textPoison.setVisibility(View.GONE);
        textWound.setVisibility(View.GONE);
        textConcussion.setVisibility(View.GONE);
        textHeartAttack.setVisibility(View.GONE);
        textAllergicReaction.setVisibility(View.GONE);
    }
}
