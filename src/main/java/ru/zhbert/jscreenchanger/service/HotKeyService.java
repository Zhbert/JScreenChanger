package ru.zhbert.jscreenchanger.service;

import com.tulskiy.keymaster.common.HotKey;
import com.tulskiy.keymaster.common.HotKeyListener;
import com.tulskiy.keymaster.common.Provider;

import javax.swing.*;

public class HotKeyService {

    private Provider provider = Provider.getCurrentProvider(false);

    private HotKeyListener listener;

    public HotKeyService() {
        this.listener = new HotKeyListener() {
            public void onHotKey(HotKey hotKey) {
                System.out.println("HotKey pressed!");
            }
        };
    }

    public void start() {
        provider.register(KeyStroke.getKeyStroke("control alt 7"), listener);
    }

    public void stop() {
        provider.reset();
        provider.stop();
    }
}
