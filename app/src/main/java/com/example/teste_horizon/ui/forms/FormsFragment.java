package com.example.teste_horizon.ui.forms;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.teste_horizon.R;
import com.example.teste_horizon.data.model.Paciente;
import com.example.teste_horizon.databinding.FragmentFormsBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FormsFragment extends Fragment {

    private FragmentFormsBinding binding;
    private FormsViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFormsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initRadioButton();
        initCadastrarButton();
    }

    private void navigateToHomeFragment(View view) {
        Navigation.findNavController(view).navigate(R.id.action_formsFragment_to_homeFragment);
    }


    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(FormsViewModel.class);
    }

    private void initRadioButton() {
        RadioGroup radioGroup = binding.radioGroup;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_positive_button:
                        binding.checkboxPaises.setVisibility(View.VISIBLE);
                        break;
                    case R.id.radio_negative_button:
                        binding.checkboxPaises.setVisibility(View.GONE);
                        binding.china.setChecked(false);
                        binding.eua.setChecked(false);
                        binding.indonesia.setChecked(false);
                        binding.italia.setChecked(false);
                        binding.portugal.setChecked(false);
                        binding.outro.setChecked(false);
                        break;
                }
            }
        });
    }

    private void initCadastrarButton() {
        binding.buttonCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean china = binding.china.isChecked();
                boolean eua = binding.eua.isChecked();
                boolean indonesia = binding.indonesia.isChecked();
                boolean italia = binding.italia.isChecked();
                boolean portugal = binding.portugal.isChecked();
                String nome = binding.nomeEditlayout.getText().toString();
                String idade = binding.idadeEditlayout.getText().toString();
                String temperatura = binding.temperaturaEditlayout.getText().toString();
                String tosse = binding.sintomaTosseEditlayout.getText().toString();
                String cefaleia = binding.sintomaCefaleiaEditlayout.getText().toString();

                Paciente paciente = new Paciente(
                        nome,
                        idade.isEmpty() ? 0 : Integer.parseInt(idade),
                        temperatura.isEmpty() ? 0.0 : Double.parseDouble(temperatura),
                        tosse.isEmpty() ? 0 : Integer.parseInt(tosse),
                        cefaleia.isEmpty() ? 0 : Integer.parseInt(cefaleia),
                        china || eua || indonesia || italia || portugal);

                Log.e("Teste", "Fragment: " + paciente);
                viewModel.cadastrarPaciente(paciente);
                navigateToHomeFragment(view);
            }
        });
    }
}
