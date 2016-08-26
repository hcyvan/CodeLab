from flask import Flask
from flask import request
from flask.templating import render_template
app=Flask(__name__)
@app.route(r"/",methods=['GET'])
def app_config():
    return render_template(r'app_config.html')

@app.route(r"/version_config",methods=['POST'])
def version_config():
    gi=[1,2,3]
    bs=[1,2,3,4]
    rs=[1,2]
    return render_template(r'version_config.html')
    


if __name__ == "__main__":
    app.run(debug=True)
