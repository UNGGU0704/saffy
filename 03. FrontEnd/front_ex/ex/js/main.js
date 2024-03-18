const likeButtons = document.querySelectorAll('.like-btn');

likeButtons.forEach(button => {
  button.addEventListener('click', handleLikeButtonClick);
});

function handleLikeButtonClick(event) {
 

  document.location.reload();
  const movieInfo = event.target.closest('.card').querySelector('.movie-info');

  const movieTitle = movieInfo.children[0].children[0].textContent;
  const genre = movieInfo.children[0].children[2].textContent;
  const director = movieInfo.children[0].children[3].textContent;
  const runningTime = movieInfo.children[0].children[4].textContent;
  
  const movieData = {
      title: movieTitle,
      genre: genre,
      director: director,
      runningTime: runningTime
  };
  let likedMovies = JSON.parse(localStorage.getItem('likedMovies')) || [];
  
  const duplicate = likedMovies.some(movie => movie.title === movieData.title);
  
  if (!duplicate) {
    likedMovies.push(movieData);
    localStorage.setItem('likedMovies', JSON.stringify(likedMovies));
  } else {
    alert('이미 찜한 영화입니다.');
  }
}
document.addEventListener('DOMContentLoaded', () => {
  const likedMoviesList = document.getElementById('liked-movies-list');
  
  const moveis = JSON.parse(localStorage.getItem('likedMovies')) || [];
  
  if (moveis.length > 0) {
    moveis.forEach(movie => {
      const row = document.createElement('tr');
      
      const movieInfoCell = document.createElement('td');
        movieInfoCell.textContent = `${movie.title} | ${movie.genre} 
                                | ${movie.director} | ${movie.runningTime}`;
      row.appendChild(movieInfoCell);
      
      likedMoviesList.appendChild(row);
    });
  } else {
    const noLikedMoviesMessage = document.createElement('tr');
    noLikedMoviesMessage.innerHTML = '<td colspan="4">아직 찜한 영화가 없습니다....</td>';
    likedMoviesList.appendChild(noLikedMoviesMessage);
  }
});

function clearLikedMovies() {
    localStorage.removeItem('likedMovies');
    location.reload();
}
