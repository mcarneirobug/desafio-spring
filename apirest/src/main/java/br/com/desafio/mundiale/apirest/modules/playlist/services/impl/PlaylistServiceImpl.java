package br.com.desafio.mundiale.apirest.modules.playlist.services.impl;

import br.com.desafio.mundiale.apirest.model.entities.Playlist;
import br.com.desafio.mundiale.apirest.model.repositories.PlaylistRepository;
import br.com.desafio.mundiale.apirest.modules.music.services.MusicService;
import br.com.desafio.mundiale.apirest.modules.playlist.mappers.PlaylistMapper;
import br.com.desafio.mundiale.apirest.modules.playlist.request.PlaylistRequest;
import br.com.desafio.mundiale.apirest.modules.playlist.response.PlaylistResponse;
import br.com.desafio.mundiale.apirest.modules.playlist.services.PlaylistService;
import br.com.desafio.mundiale.apirest.modules.playlist.update.PlaylistUpdate;
import br.com.desafio.mundiale.apirest.modules.user.services.UserService;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private MusicService musicService;

    public PlaylistServiceImpl(PlaylistRepository playlistRepository, UserService userService, MusicService musicService) {
        this.playlistRepository = playlistRepository;
        this.userService = userService;
        this.musicService = musicService;
    }

    public PlaylistResponse create(PlaylistRequest playlistRequest) throws NotFoundException {
        final var user = userService.searchById(playlistRequest.getId_user_who_created());
        final var playlist = PlaylistMapper.to(playlistRequest, user);
        return PlaylistMapper.toResponse(this.playlistRepository.save(playlist));
    }

    @Override
    public List<PlaylistResponse> searchAll() {
        return this.playlistRepository.findAll()
                .stream()
                .map(PlaylistMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public Playlist searchById(Long id) throws NotFoundException {
        return this.playlistRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("Não foi encontrado nenhuma playlist com o id informado."));
    }

    @Override
    public PlaylistResponse associateMusic(Long idPlaylist, Long idMusic) throws NotFoundException {
        final var music = musicService.searchById(idMusic);
        final var playlist = this.searchById(idPlaylist);

        playlist.getMusics().add(music); // vai pegar a música e adicionar na lista

        return PlaylistMapper.toResponse(this.playlistRepository.save(playlist));
    }

    @Override
    public PlaylistResponse searchAllMusic(Long idPlaylist) throws NotFoundException {
        final var playlist = searchById(idPlaylist);
        return PlaylistMapper.toResponseOnlyMusic(playlist);
    }

    @Override
    public Playlist update(Long id, PlaylistUpdate playlistUpdate) throws NotFoundException {

        final Playlist playlist = this.playlistRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Não foi encontrado playlist para o ID informado!"));
        playlist.setName(playlistUpdate.getName());
        playlist.setDescription(playlistUpdate.getDescription());
        playlist.setRatingPlaylist(playlistUpdate.getRatingPlaylist());
        return this.playlistRepository.save(playlist);
    }

//    public Playlist associateUser(Long id_playlist, Long id_user) throws NotFoundException {
//        final var user = userService.searchById(id_user);
//        final var playlist = this.searchById(id_playlist);
//
//        playlist.setUser(user); // pega o usuário e adiciona ele na playlist
//
//        return this.playlistRepository.save(playlist);
//    }


//    public List<Playlist> listAllPlaylist(Long id_user, List<Playlist> playlists) throws NotFoundException {
//        final var user = userService.searchById(id_user);
//        final var playlist = playlistRepository

//        if (playlist.getUser().getId().equals(user.getId())) {
//            return playlist;
//        }
//        return null;
//    }

//    public Playlist associate(Long id_playlist, Long id_user) throws NotFoundException {
//        final var user = userService.searchById(id_user);
//        final var playlist = this.searchById(id_playlist);
//        playlist.setUser(user);
//        playlist.getUser().getPlaylists().add(playlist);
//        playlist.getMusics().addAll(user.getMusics());
//        return this.playlistRepository.save(playlist);
//    }

//    public Playlist associateMusic(Long id_playlist, Long id_user) throws NotFoundException {
//        final var user = userService.searchById(id_user);
//        final var playlist = this.searchById(id_playlist);
//        playlist.getMusics().addAll(user.getMusics());
//        return this.playlistRepository.save(playlist);
//    }

//    public Playlist update(Playlist playlist) throws NotFoundException {
//        this.searchById(playlist.getId());
//        return this.playlistRepository.save(playlist);
//    }
}
