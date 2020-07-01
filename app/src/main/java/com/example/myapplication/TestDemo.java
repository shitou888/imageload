package com.example.myapplication;

import android.graphics.Bitmap;
import android.util.LruCache;

public class TestDemo {
    LruCache<String, Bitmap> mImageCache;

    public TestDemo() {
        initImageCache();
    }

    private void initImageCache() {
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxMemory / 4;
        mImageCache = new LruCache<String, Bitmap>(cacheSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };

    }

}
