package be.ehb.notedroid.data;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;

public class NoteViewModel extends AndroidViewModel {

    MutableLiveData<ArrayList<Note>> noteLiveData;

    public NoteViewModel(
            @NonNull Application application) {
        super(application);
        noteLiveData = new MutableLiveData<>();
        setupNotes();
    }

    //replace this part with db/api
    private void setupNotes(){
        ArrayList<Note> notes = new ArrayList<>();
        //region hardcoded notes
        notes.add(
                new Note("Workout", "5 sets of pullups and dips", null)
        );
        notes.add(
                new Note("Study", "Finish Notedroid deel 1", null)
        ); notes.add(
                new Note("Groceries", "Apples, Milk, Oats and Water", null)
        );
        //endregion
        noteLiveData.setValue(notes);
    }
    public MutableLiveData<ArrayList<Note>> getNoteLiveData() {
        return noteLiveData;
    }

}
