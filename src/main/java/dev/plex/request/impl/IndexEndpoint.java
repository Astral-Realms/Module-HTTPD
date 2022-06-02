package dev.plex.request.impl;

import dev.plex.request.AbstractServlet;
import dev.plex.request.GetMapping;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bukkit.Bukkit;

public class IndexEndpoint extends AbstractServlet
{
    @GetMapping(endpoint = "//")
    public String getIndex(HttpServletRequest request, HttpServletResponse response)
    {
        return indexHTML();
    }

    @GetMapping(endpoint = "/api/")
    public String getAPI(HttpServletRequest request, HttpServletResponse response)
    {
        return indexHTML();
    }

    private String indexHTML()
    {
        String file = readFile(this.getClass().getResourceAsStream("/httpd/index.html"));
        file = file.replace("${MESSAGE}", "<p class=\"center\">Welcome to the HTTPD for the Astral Realms Free OP server!</p>" +
                "<br>" +
                "<p class=\"center\">We know it looks quite bland right now, but more updates to it will come soon, stay tuned!</p>");
        return file;
    }
}
