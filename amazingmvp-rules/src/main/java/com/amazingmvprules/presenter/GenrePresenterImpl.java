/*
* Copyright (C) 2016 Pedro Paulo de Amorim
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.amazingmvprules.presenter;

import android.os.Bundle;
import com.amazingmvprules.domain.model.Genre;
import com.amazingmvprules.domain.model.SubGenre;
import com.amazingmvprules.domain.util.Tags;
import java.util.List;
import javax.inject.Inject;

public class GenrePresenterImpl implements GenrePresenter {

  private View view;
  private Genre genre;

  @Inject GenrePresenterImpl() { }

  @Override public void setView(View view) {
    if (view == null) {
      throw new IllegalArgumentException("The view must not be null!");
    }
    this.view = view;
  }

  @Override public void setGenre(Genre genre) {
    this.genre = genre;
    loadSubGenres();
  }

  @Override public Bundle saveInstance(Bundle instance) {
    if (instance != null && genre != null) {
      instance.putParcelable(Tags.GENRE, genre);
    }
    return instance;
  }

  @Override public void restoreInstance(Bundle instance) {
    if (instance != null && instance.containsKey(Tags.GENRES)) {
      genre = instance.getParcelable(Tags.GENRE);
    }
  }

  @Override public SubGenre getSubGenreAtPosition(int position) {
    if (genre == null) {
      return null;
    }
    List<SubGenre> subGenres = genre.getSubGenres();
    return subGenres != null ? subGenres.get(position) : null;
  }

  private void loadSubGenres() {
    if (view.isReady() && genre != null) {
      view.renderGenres(genre.getSubGenres());
    }
  }

}
