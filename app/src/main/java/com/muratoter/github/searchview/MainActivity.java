package com.muratoter.github.searchview;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;
    private ArrayList<Movies> arrayList=new ArrayList<Movies>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        final LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        moviesLoad();
        adapter=new RecyclerViewAdapter(this,arrayList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void moviesLoad(){
        arrayList.add(new Movies("Olanlar Oldu","Zafer ve annesi Döndü Hanım Ege’nin bir kıyı kasabasında birlikte yaşamaktadır. Yaşı geçmekte olan oğlunun kasabanın güzeli Mehtap’tan ayrılmış olmasına ve hala evlenmemiş olmasına üzülen Döndü, bu gidişata son vermek için harekete geçer. Bu esnada mütevazı teknesinin sorunlarıyla boğuşan Zafer’in yaptığı mavi turda olanlar olur!"));
        arrayList.add(new Movies("Parçalanmış","Başrollerini X-Men serisinin genç Charles Xavier'ı James McAvoy, The Witch ile yıldızı parlayan Anya Taylor-Joy ve Betty Buckley'nin üstlendiği gerilim filmi Split'in yönetmen, senarist ve yapımcılığını gerilim filmlerinin inişli çıkışlı yönetmeni M. Night Shyamalan üstleniyor. Jason Blum da filmin yapımcıları arasında yer alıyor. "));
        arrayList.add(new Movies("Moana","Moana Antik Polenezya'da yaşayan bir kabilenin şefinin cesur kızıdır. Güçlü ve korkusuz Moana doğanın içinde büyümüştür ve neşeli bir kızdır. Ancak yarı tanrı Maui tarafından yapılan korkunç bir lanet onun adasına dek ulaşır."));
        arrayList.add(new Movies("Cereyan","Henüz 2. sınıfta psikoloji öğrencisi olan genç kadın Aylin, geceleri tanımadığı kişilerle internet üzerinden canlı bağlantı ile terapi yapmakta ve bunun kendisini geliştireceğini düşünmektedir. Bir gece onu Cavit isimli tuhaf bir adam arar. Kanser hastası olan 7 yaşındaki oğlunun ölümüne sebep olduğunu ve depresyondan kurtulamadığını söyler."));
        arrayList.add(new Movies("Ay Işığı","İnsan ilişkileri ve insanın kendini keşfetmesi hakkında bir film olan Ay Işığı, genç siyahi bir adamın çocukluğundan yetişkinliğe kadar Miami'nin zor bir mahallesinde, hayatta kendine yer edinme savaşını ve büyüme hikayesini anlatıyor. "));
        arrayList.add(new Movies("Fırıldak Ailesi","Bir tarafta ise halay çeken, okeye dördüncü arayan Fırıldak Ailesi, diğer tarafta ise büyülü ormanlar, tılsımlar ve ejderhalar! Macera bir gece ansızın köydeki tüm kadınların kaçırılmasıyla başlar. Bu olay Sabri Fırıldak ve arkadaşlarını pek çok korkunç yaratıkla dolu büyülü ormana sürükler. "));
        arrayList.add(new Movies("Recep İvedik 5","Recep İvedik 5, 16 Şubat 2017 tarihinde vizyona giren Recep İvedik serisinin 5. filmidir. Togan Gökbakar tarafından yönetilecek filmin başrolünde aynı zamanda filmin senaristi olan Şahan Gökbakar yer alacaktır."));
        arrayList.add(new Movies("Recep İvedik 4","Recep İvedik 4, 21 Şubat 2014 tarihinde vizyona giren Recep İvedik 3'ün devam filmidir.Yönetmenliği ve senaristliği Togan Gökbakar üstlenmiştir. Filmin yapımcılığını Emrah Çoban yapmıştır. Filmin ana karakterini Şahan Gökbakar paylaşmaktadır."));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        MenuItem menuItem=menu.findItem(R.id.search);
        SearchView searchView=(SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        newText=newText.toLowerCase();
        ArrayList<Movies> movies=new ArrayList<>();
        for(Movies movie:arrayList){
            String movieName=movie.getMoviesName().toLowerCase();
            if(movieName.contains(newText))
                movies.add(movie);
        }
        adapter.setFilter(movies);
        return true;
    }
}
