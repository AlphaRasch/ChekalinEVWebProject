package ru.mirea.chekalin.MrPoopybutthole;

import com.fasterxml.jackson.databind.json.JsonMapper;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

public class EpisodeClient {

    public static void main(String[] args) throws IOException {
        Retrofit client = new Retrofit
                .Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(JacksonConverterFactory.create(new JsonMapper()))
                .build();

        EpisodeService episodeService = client.create(EpisodeService.class);
        int currentPage = 1;
        int maxPage = 1;
        Episode maxCharactersEpisode = null;

        while (true) {
            Response<Result> response = episodeService.getEpisodes(currentPage).execute();

            if (!response.isSuccessful() || response.body() == null) {
                System.out.println("Ошибка: " + response.code());
                return;
            }

            Result result = response.body();

            for (Episode episode : result.getResults()) {
                int charactersCount = episode.getCharacters().size();

                if (maxCharactersEpisode == null || charactersCount > maxCharactersEpisode.getCharacters().size()) {
                    maxCharactersEpisode = episode;
                    maxPage = currentPage;
                }
            }

            // Если следующая страница отсутствует, выходим из цикла
            if (result.getInfo().getNext() == null) {
                break;
            }

            // Переходим к следующей странице
            currentPage++;
        }

        if (maxCharactersEpisode != null) {
            System.out.printf("Максимальное количество персонажей: %s\n Было найдено в серии: %s\n На станице: %s с id: %s \n",
                    maxCharactersEpisode.getCharacters().size(),
                    maxCharactersEpisode.getName(),
                    maxPage,
                    maxCharactersEpisode.getId());
        }
    }
}
