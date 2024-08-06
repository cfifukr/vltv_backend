package com.example.vltv.controllers;


import com.example.vltv.dtos.request.create.MapCreateDto;
import com.example.vltv.dtos.response.GameResponseDto;
import com.example.vltv.dtos.response.MapInfoResponseDto;
import com.example.vltv.models.game.GameInfo;
import com.example.vltv.models.game.MapInfo;
import com.example.vltv.service.GameService;
import com.example.vltv.service.MapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/map")
@CrossOrigin
public class MapController {
    private final MapService mapService;
    private final GameService gameService;

    @Autowired
    public MapController(MapService mapService,
                         GameService gameService){
        this.mapService = mapService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<?> getMapById(@RequestParam("id") Long mapId){

        MapInfo mapInfo = mapService.getMap(mapId);

        return ResponseEntity.ok(MapInfoResponseDto.getDto(mapInfo));

    }

    @PostMapping
    public ResponseEntity<?> addMap(@RequestBody MapCreateDto mapCreateDto){

        MapInfo map = mapService.createMap(mapCreateDto);

        return ResponseEntity.ok(MapInfoResponseDto.getDto(map));

    }
}
