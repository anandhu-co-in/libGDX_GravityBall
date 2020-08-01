package in.minaton.tapdots;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;

public class MyGameClass extends ApplicationAdapter {


	OrthographicCamera cam;
	ShapeRenderer sr;
	Vector3 pos;
	int xinc,yinc;

	@Override
	public void create () {
		sr=new ShapeRenderer();
		//cam=new OrthographicCamera();
		pos= new Vector3(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2,0);
		//cam.setToOrtho(false,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

	}

	@Override
	public void render () {

		pos.x+=Gdx.input.getAccelerometerY()*7;
		pos.y-=Gdx.input.getAccelerometerX()*7;

		if(pos.x<30)pos.x=30;
		if(pos.x>Gdx.graphics.getWidth()-30)pos.x=Gdx.graphics.getWidth()-30;
		if(pos.y<30)pos.y=30;
		if(pos.y>Gdx.graphics.getHeight()-30)pos.y=Gdx.graphics.getHeight()-30;


		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		sr.begin(ShapeRenderer.ShapeType.Filled);
		sr.setColor(Color.WHITE);
		sr.circle(pos.x,pos.y,30);
		sr.end();

		//pos.x++;
		//pos.y++;

	}
	
	@Override
	public void dispose () {
		sr.dispose();
	}
}
