
package br.com.fernandosousa.lmsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class MapaFragment : Fragment(), OnMapReadyCallback {
    private var map: GoogleMap? = null
    override fun onMapReady(googleMap: GoogleMap?) {
        this.map = googleMap

        val location =  LatLng(-23.525322, -46.649481)


        val update = CameraUpdateFactory.newLatLngZoom(location, 18f)
        map?.moveCamera(update)

        // colocar um marcado no local selecionado
        map?.addMarker(MarkerOptions()

                .title("FIT")
                .snippet("Faculdade Impacta de Tecnologia")
                .position(location)
        )

        // tipo do papa
        map?.mapType=GoogleMap.MAP_TYPE_NORMAL
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_mapa, container, false)
        val mapFragment = childFragmentManager.findFragmentById(R.id.mapFragment)
                as SupportMapFragment
        mapFragment.getMapAsync(this)
        return view
    }
}