package com.example.teste_horizon.ui.home;

import static com.example.teste_horizon.core.Constantes.LIBERADO;
import static com.example.teste_horizon.core.Constantes.QUARENTENA;
import static com.example.teste_horizon.core.Constantes.TRATAMENTO;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuHost;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.teste_horizon.R;
import com.example.teste_horizon.data.model.Paciente;
import com.example.teste_horizon.databinding.FragmentHomeBinding;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private HomeAdapter adapter;
    Toolbar toolbar;


    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        initToolbar();
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
        navigateToFormsFragment(view);
        iniRecyclerView();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.home_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menu_todos) {
            List<Paciente> pacientes = viewModel.getPacientes();
            adapter.setPacientesList(pacientes);
            adapter.notifyDataSetChanged();
        }
        if (id == R.id.menu_tratamento) {
            List<Paciente> tratamento = viewModel.filtrarLista(TRATAMENTO);
            adapter.setPacientesList(tratamento);
            adapter.notifyDataSetChanged();
        }
        if (id == R.id.menu_quarentena) {
            List<Paciente> quarentena = viewModel.filtrarLista(QUARENTENA);
            adapter.setPacientesList(quarentena);
            adapter.notifyDataSetChanged();
        }
        if (id == R.id.menu_liberado) {
            List<Paciente> liberado = viewModel.filtrarLista(LIBERADO);
            adapter.setPacientesList(liberado);
            adapter.notifyDataSetChanged();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        toolbar = binding.toolbar;
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        toolbar.setTitle("");
    }

    private void navigateToFormsFragment(View view) {
        binding.fabAddPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_formsFragment);
            }
        });
    }

    private void iniRecyclerView() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        adapter = new HomeAdapter();
        binding.rvHome.setAdapter(adapter);
        List<Paciente> pacientes = viewModel.getPacientes();
        adapter.setPacientesList(pacientes);
    }
}