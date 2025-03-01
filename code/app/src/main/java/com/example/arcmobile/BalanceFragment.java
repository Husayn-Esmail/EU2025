package com.example.arcmobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.arcmobile.databinding.FragmentBalanceBinding;

import java.util.Objects;

public class BalanceFragment extends Fragment {

    private FragmentBalanceBinding binding;



    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentBalanceBinding.inflate(inflater, container, false);

        String[] transactions = getResources().getStringArray(R.array.transactions);

        ListView listView = binding.transactionList;

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, transactions);
        listView.setAdapter(adapter);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {
            int addedAmnt = bundle.getInt("addedAmnt", 0); // Default value is 0
            binding.balanceText.setText(String.valueOf(addedAmnt+10));
        }

        binding.addBalanceButton.setOnClickListener(v ->
                NavHostFragment.findNavController(BalanceFragment.this)
                        .navigate(R.id.action_BalanceFragment_to_ReloadFragment)
        );
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}