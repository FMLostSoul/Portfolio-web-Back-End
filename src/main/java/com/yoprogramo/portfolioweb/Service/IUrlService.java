/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.yoprogramo.portfolioweb.Service;

import com.yoprogramo.portfolioweb.Model.Url;
import java.util.List;

/**
 *
 * @author franc
 */
public interface IUrlService {
    
    public void save(List<Url> urls);
    
    public List<Url> getUrls();
    
    public Url getByUrlId(int id);
    
}
