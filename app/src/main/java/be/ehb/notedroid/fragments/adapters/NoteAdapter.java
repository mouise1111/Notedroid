package be.ehb.notedroid.fragments.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import be.ehb.notedroid.R;
import be.ehb.notedroid.data.Note;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteViewHolder>{

    class NoteViewHolder extends RecyclerView.ViewHolder {
        final TextView tvTitle, tvDate;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDate = itemView.findViewById(R.id.tv_date);
        }
    }
    ArrayList<Note> items;

    public NoteAdapter() {
        this.items = new ArrayList<>();
    }

    public NoteAdapter(ArrayList<Note> items) {
        this.items = items;
    }

    public void setItems(ArrayList<Note> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =
                LayoutInflater.from
                        (parent.getContext()).inflate(R.layout.row_for_note,
                        parent,
                        false);

        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note currentItem = items.get(position);
        holder.tvTitle.setText(currentItem.getTitle());
//        holder.tvDate.setText((currentItem.getDate()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
