package com.amazingmvp.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.amazingmvp.R;
import com.amazingmvprules.domain.model.Genre;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;

/**
  * This class represent the adapter of the RecyclerView
  * and will load the Genre of the Tab.
  */
public class GenreAdapter extends RecyclerView.Adapter<GenreAdapter.ViewHolder> {

  private ArrayList<Genre> genres = null;

  /**
   * This constructor will be used to configure the
   * RecyclerView of the GenreFragment.
   * @param genres Array of Genres
   */
  public GenreAdapter(ArrayList<Genre> genres) {
    this.genres = genres;
  }

  /**
   * This method will load create ViewHolder and inflate the layout.
   * @param parent The RecyclerView.
   * @param viewType The type of the adapter to be inflated.
   * @return The ViewHolder created and with the layout inflated.
   */
  @Override public GenreAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
      int viewType) {
    return new ViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.adapter_genre, parent, false));
  }

  /**
   * This method will load the data to the adapter, based
   * on the position of the adapter, this will get the
   * ViewHolder and configure these infos.
   * This method will be used to create the detail item too
   * and be used to inform to the user about the date of the
   * first and last Genre. Based on the information of the
   * method getItemViewType.
   * @param viewHolder Instance of ViewHolder of this Adapter.
   * @param position Position of the item in the Adapter.
   */
  @Override public void onBindViewHolder(GenreAdapter.ViewHolder viewHolder, int position) {
    viewHolder.configView(getItemAtPosition(position));
  }

  /**
   * This method is needed to inform to the adapter how
   * many items has this adapter.
   * If Genres is equals to null, return 0.
   * @return The size of Genres.
   */
  @Override public int getItemCount() {
    return genres != null ? genres.size() : 0;
  }

  /**
   * This method will be used to get a Genre object,
   * this object need to be on the ArrayList and can be
   * requested by the method onBindViewHolder of this Adapter.
   * @param index Position of the item on ArrayList.
   * @return Genre object.
   */
  public Genre getItemAtPosition(int index) {
    return genres != null ? genres.get(index) : null;
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {

    @Bind(R.id.genre_name) TextView genreName;
    @Bind(R.id.genre_image) SimpleDraweeView genreImage;

    public ViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }

    public void configView(Genre genre) {
      genreName.setText(genre.getTitle());
      genreImage.setImageURI(Uri.parse(genre.getImage()));
    }

  }

}