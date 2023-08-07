package com.crio.shorturl;

import java.util.*;
import java.util.Map.Entry;

public class XUrlImpl implements XUrl{
    
    Random r = new Random();
    String listOfChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    HashMap<String,String> map=new HashMap<>();
    HashMap<String,Integer> count = new HashMap<>();
    Integer hitCount = 0;

    public String registerNewUrl(String longUrl){
        StringBuilder shortURL = new StringBuilder("http://short.url/");
        for(int i=0;i<9;i++){
            shortURL.append(listOfChar.charAt(r.nextInt(listOfChar.length())));
        }
        if(map.containsKey(longUrl)){
            return map.get(longUrl);
        }
        return registerNewUrl(longUrl, shortURL.toString());
    }

    public String getUrl(String shortUrl){
        String s = null;
        for(Entry<String,String> entry : map.entrySet()){
            if(entry.getValue() == shortUrl){
                s = entry.getKey();
                if(count.containsKey(entry.getKey())){
                    count.put(entry.getKey(), count.get(entry.getKey())+1);
                }else{
                    count.put(entry.getKey(),0);
                }
            }
        }
        return s;
    }

    public String delete(String longUrl){
        map.remove(longUrl);
        String s = null;
        if(!map.containsKey(longUrl)){
            return s;
        }
        return s;
    }

    @Override
    public String registerNewUrl(String longUrl, String shortUrl){
        String result = null;
        if(map.containsValue(shortUrl)){
            return result;
        }else{
            map.put(longUrl, shortUrl);
            count.put(longUrl, 0);
            result = shortUrl;
        }
        return result;
    }

    @Override
    public Integer getHitCount(String longUrl) {
        if(count.containsKey(longUrl)){
            return count.get(longUrl);
        }else{
            return 0;
        }
    }
    
}