package com.example.tdfragment.activities;


import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import com.example.tdfragment.R;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlayWithFocus;
import org.osmdroid.views.overlay.OverlayItem;

import java.util.ArrayList;

public class MapActivity extends AppCompatActivity {
    private MapView map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Configuration.getInstance().load(
                getApplicationContext(),
                PreferenceManager.getDefaultSharedPreferences(getApplicationContext())
        );
        setContentView(R.layout.activity_map);
        map =findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls( true);
        GeoPoint startPoint=new GeoPoint(43.616218,7.00517);
        IMapController mapController =map.getController();
        mapController.setZoom(18.0);
        mapController.setCenter(startPoint);

        ArrayList<OverlayItem> items=new ArrayList<>();
        OverlayItem home = new OverlayItem(
                "Kevin's office",
                "My office",
                new GeoPoint(43.616218,7.071950));
        Drawable marker=home.getMarker(0);
        items.add(home);
        items.add(new OverlayItem("Restaurant",
                "chez Babar",
                new GeoPoint(43.615916,7.072422)));

        ItemizedOverlayWithFocus<OverlayItem> mOverlay=new ItemizedOverlayWithFocus<OverlayItem>(
                getApplicationContext(),
                items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(int index, OverlayItem item) {
                        return true;
                    }

                    @Override
                    public boolean onItemLongPress(int index, OverlayItem item) {
                        return false;
                    }
                }
        );
        mOverlay.setFocusItemsOnTap(true);
        map.getOverlays().add(mOverlay);
    }

    @Override
    public void onPause(){
        super.onPause();
        map.onPause();
    }

    @Override
    public  void onResume(){
        super.onResume();
        map.onResume();
    }
}
