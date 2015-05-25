package br.ufc.dc.sd4mp.mymap;

import android.location.Location;
import android.os.Bundle;


import android.app.Activity;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class MyMap extends Activity implements ConnectionCallbacks, OnConnectionFailedListener {

    private GoogleMap googleMap;
    private GoogleApiClient googleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_map);
        initMap();

        GoogleApiClient.Builder builder = new GoogleApiClient.Builder(this);
        builder.addApi(LocationServices.API);
        builder.addConnectionCallbacks(this);
        builder.addOnConnectionFailedListener(this);
        googleApiClient = builder.build();
    }

    private void initMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(), "Sorry! unable to create maps", Toast.LENGTH_SHORT).show();
            } else {
                googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            }
        }
    }

    public void getLocation(View view) {
        //double latitude = -3.7460927;
        //double longitude = -38.5743825;

        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        MarkerOptions marker = new MarkerOptions().position(new LatLng(location.getLatitude(), location.getLongitude())).title("You are here!");
        googleMap.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(16).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }

    @Override
    protected void onResume() {
        super.onResume();
        initMap();
    }

    @Override
    protected void onStart() {
        super.onStart();
        googleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        googleApiClient.disconnect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        //Toast.makeText(this, "Connected!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionSuspended(int value) {
        //Toast.makeText(this, "Disconnected!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Toast.makeText(this, "Connection failed...", Toast.LENGTH_LONG).show();
    }
}

