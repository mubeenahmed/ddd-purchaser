
from flask import Flask
from flask import request
from config.config import DevelopmentConfig as config
from elasticsearch_service.search import Search

app = Flask(__name__)
app.config['DEBUG'] = config.DEBUG
app.config['FLASK_ENV'] = config.ENV
app.config['FLASK_APP'] = config.APP


@app.route('/')
def index():
    return 'home'

@app.route('/search')
def search():
    user_search = request.args.get('q')
    if not user_search:
        raise AssertionError('query not defined')

    elasticsearch_search = Search(user_search)
    results = elasticsearch_search.get_result()
    return results
    