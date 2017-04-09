/*
 * Copyright 2015 Benedikt Ritter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.heroku.demo.web;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

import com.heroku.demo.domain.Station;
import com.heroku.demo.domain.TimeTrack;
import com.heroku.demo.domain.TimeTrackRepository;
import com.heroku.demo.service.TimeTrackDto;
import com.heroku.demo.service.TimeTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class HomeController {

    private TimeTrackService service;

    @Autowired
    public HomeController(TimeTrackService theService) {
        this.service = theService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login() {
        return "login";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String home(HttpServletRequest request, ModelMap model, Principal principal) {
        List<TimeTrackDto> timeTracks = service.listTimeTracks();
        model.addAttribute("timeTracks", timeTracks);
        model.addAttribute("insertRecord", new TimeTrack());
        model.addAttribute("stationTypes", Station.values());
        return "home";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String  insertData(Principal principal, HttpServletRequest request, ModelMap model,
                             @ModelAttribute("insertRecord") @Valid TimeTrackDto timeTrack,
                             BindingResult result) {
        if (!result.hasErrors()) {
            service.addTimeTrack(timeTrack, principal.getName());
        }
        return home(request, model, principal);
    }
}
