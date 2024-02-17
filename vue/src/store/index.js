import { createStore as _createStore } from 'vuex';
import axios from 'axios';
import { stat } from 'fs';

export function createStore(currentToken, currentUser) {
  let store = _createStore({
    state: {
      token: currentToken || '',
      user: currentUser || {},
      blogPost: {},
      blogPosts: []
    },
    mutations: {
      SET_AUTH_TOKEN(state, token) {
        state.token = token;
        localStorage.setItem('token', token);
        axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
      },
      SET_USER(state, user) {
        state.user = user;
        localStorage.setItem('user', JSON.stringify(user));
      },
      LOGOUT(state) {
        localStorage.removeItem('token');
        localStorage.removeItem('user');
        state.token = '';
        state.user = {};
        axios.defaults.headers.common = {};
      },
      ADD_BLOG_POST(state, blogPost) {
        state.blogPost = blogPost;
      },
      ADD_BLOG_POSTS(state, blogPosts) {
        state.blogPosts = blogPosts;
      },
      UPDATE_BLOG_POST(state, blogPost) {
        state.blogPost = blogPost;
      }
    },
  });
  return store;
}
