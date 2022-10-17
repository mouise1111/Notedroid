package be.ehb.notedroid.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.notedroid.R;
import be.ehb.notedroid.data.Note;
import be.ehb.notedroid.data.NoteViewModel;
import be.ehb.notedroid.fragments.adapters.NoteAdapter;

public class NoteListfFragment extends Fragment {
    public NoteListfFragment(){}

    public static NoteListfFragment newInstance(){
        return new NoteListfFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notelist, container, false);
        RecyclerView rvNotes = view.findViewById(R.id.rv_notes);
        NoteAdapter noteAdapter = new NoteAdapter();
        RecyclerView.LayoutManager manager = new LinearLayoutManager(
                getContext(),
                RecyclerView.VERTICAL,
                false
        );
        NoteViewModel noteViewModel = new ViewModelProvider(getActivity()).get(NoteViewModel.class);
        rvNotes.setAdapter(noteAdapter);
        rvNotes.setLayoutManager(manager);

        noteViewModel.getNoteLiveData().observe(getActivity(), new Observer<ArrayList<Note>>() {
            @Override
            public void onChanged(ArrayList<Note> notes) {
                noteAdapter.setItems(notes);
            }
        });
        return view;
    }
}
