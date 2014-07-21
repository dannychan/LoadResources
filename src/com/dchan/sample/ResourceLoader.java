package com.dchan.sample;

import android.content.Context;
import android.content.pm.ApplicationInfo;

import java.util.Enumeration;

import dalvik.system.DexFile;

/**
 * Created by dannychan on 7/21/14.
 */
public class ResourceLoader {
    // This is the value that android uses when a resource isn't found
    private static int INVALID_RESOURCE_IDENTIFIER = 0;

    public static int getIdentifier(Context c, String name, String defType, String defPackage) {
        int id = c.getResources().getIdentifier(name, defType, defPackage);

        // Early exit when we've found the identifier through normal means
        if (id != INVALID_RESOURCE_IDENTIFIER) {
            return id;
        }

        try {
            // Gets the location of the dex file
            ApplicationInfo info = c.getPackageManager().getApplicationInfo(c.getPackageName(), 0);
            // Loads the dex file
            DexFile f = new DexFile(info.sourceDir);
            // Gets the classes inside the dex file
            Enumeration<String> names = f.entries();

            // Look for the R class and then tries to load the resource with the R class's package name
            while(names.hasMoreElements()) {
                String s = names.nextElement();
                if (s.endsWith(".R")) {
                    id = c.getResources().getIdentifier(name, defType, s.substring(0, s.length() - 2));
                    if (id != INVALID_RESOURCE_IDENTIFIER) {
                        return id;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }
}
