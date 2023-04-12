from flask import Flask, render_template, request, make_response

app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html')

@app.route('/cookie', methods=['POST'])
def cookie():
    value = request.form['value']

    if value:
        resp = make_response('Cookie created! Value: ' + value)
        resp.set_cookie('myCookie', value, max_age=60 * 60 * 24) # 1 day
        return resp

    myCookie = request.cookies.get('myCookie')
    return 'Retrieved cookie: ' + myCookie if myCookie else 'No cookie found.'

if __name__ == '__main__':
    app.run()
