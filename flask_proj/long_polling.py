import time
from flask import Flask, request, jsonify
from flask.templating import render_template
app=Flask(__name__)
@app.route(r"/main",methods=['GET'])
def main():
	if request.args.get("get_time"):
		while True:
			time.sleep(2)	
			f="%Y-%m-%d %X"
			ts=time.strftime(f, time.localtime());
			print ts
		return jsonify({"time":ts})
	elif request.args.get("get_time_now"):
		f="%Y-%m-%d %X"
		ts=time.strftime(f, time.localtime());
		return jsonify({"time_now":ts})
	else:
		return render_template('long_polling.html');



if __name__ == "__main__":
   	app.run(debug=True, threaded=True)
   	#app.run(threaded=True)
   	#app.run()
