
from flask import Flask
from flask import request
from config.config import DevelopmentConfig as config
from elasticsearch_service.search import Search
from flask import jsonify

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
    return jsonify(results)

@app.route('/search/all')
def search_all():
    page_index = request.args.get('page_index')
    page_size = request.args.get('page_size')

    elasticsearch_search = Search(None)
    results = elasticsearch_search.get_all_result()
    return jsonify(results)

@app.route('/search/<id>')
def search_by_id(id):
    elasticsearch_search = Search(None)
    results = elasticsearch_search.get_by_id(id)
    return jsonify(results)
    